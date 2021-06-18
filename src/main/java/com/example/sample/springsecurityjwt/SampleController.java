package com.example.sample.springsecurityjwt;

import com.example.sample.springsecurityjwt.models.AuthenticationRequest;
import com.example.sample.springsecurityjwt.models.AuthenticationResponse;
import com.example.sample.springsecurityjwt.services.MyUserDetails;
import com.example.sample.springsecurityjwt.services.MyUserDetailsService;
import com.example.sample.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @RequestMapping("/sample")
    public String Sample() {
        return "Sample Code";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


    @GetMapping(value = "/info")
    public String[] index(@AuthenticationPrincipal MyUserDetails principal) {
        String userEmail = principal.getEmail();
        String userUserName = principal.getUsername();
        String userName = principal.getName();

        String[] info = new String[3];

            info[0] = "Name: " + userName;
            info[1] = "Email: " + userEmail;
            info[2] = "Username: " + userUserName;

            return info;
    }
}





