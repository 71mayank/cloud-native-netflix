package za.co.bank.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.bank.outbound.BankOutboundPayload;
import za.co.bank.service.impl.BankServiceImpl;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@Api(value = "Bank Service ", description = "Operations related to Bank")
public class BankController {

    @Autowired
    BankServiceImpl accountServiceImpl;

    @ApiOperation(value = "Get Bank information for specified account id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved bank information for specified account id"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/bank/{id}")
    public ResponseEntity<BankOutboundPayload> getAccountById(@Valid @PathVariable Long id) {
        return accountServiceImpl.getAccountById(id);
    }

}