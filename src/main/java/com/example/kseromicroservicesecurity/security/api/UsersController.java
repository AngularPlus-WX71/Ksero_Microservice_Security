package com.example.kseromicroservicesecurity.security.api;

import com.example.kseromicroservicesecurity.security.domain.service.UserService;
import com.example.kseromicroservicesecurity.security.domain.service.communication.AuthenticateRequest;
import com.example.kseromicroservicesecurity.security.domain.service.communication.RegisterRequest;
import com.example.kseromicroservicesecurity.security.mapping.UserMapper;
import com.example.kseromicroservicesecurity.security.resource.UserResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SecurityRequirement(name = "acme")
@Tag(name="Users", description = "Create, read, update and delete users")
@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;
    private final UserMapper mapper;

    public UsersController(UserService userService, UserMapper mapper){
        this.mapper = mapper;
        this.userService = userService;
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody
                                              AuthenticateRequest request){
        return userService.authenticate(request);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody
                                          RegisterRequest request){
        return userService.register(request);
    }

    @GetMapping("/auth/get-all")
    public List<UserResource> getAllUsers(){
        return mapper.toResource(userService.getAll());
    }

    @GetMapping("/auth/verify-token-retail-seller")
    @PreAuthorize("hasRole('RETAIL_SELLER')")
    public boolean verifyTokenRetailSeller(){
        return true;
    }

    @GetMapping("/auth/verify-token-wholesaler")
    @PreAuthorize("hasRole('WHOLESALER')")
    public boolean verifyTokenWholesaler(){
        return true;
    }

}