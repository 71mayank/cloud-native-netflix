package za.co.account.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.account.outbound.AccountOutboundPayload;
import za.co.account.service.impl.AccountServiceImpl;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@Api(value = "Account Service ", description = "Operations related to Account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountserviceimpl;

    @ApiOperation(value = "Create an account", response = AccountOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created an account"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping(value = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountOutboundPayload> createAccount(@Valid @PathVariable Long id) {
        return accountserviceimpl.createAccount(id);
    }

    @ApiOperation(value = "Get Accounts", response = AccountOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully listed all account"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountOutboundPayload>> getAccounts() {
        return accountserviceimpl.getAccounts();
    }

    @ApiOperation(value = "Get Account by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved account"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountOutboundPayload> getAccountById(@Valid @PathVariable Long id) {
        return accountserviceimpl.getAccountById(id);
    }




}