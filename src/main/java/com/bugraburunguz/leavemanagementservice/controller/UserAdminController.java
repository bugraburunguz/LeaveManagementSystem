package com.bugraburunguz.leavemanagementservice.controller;

import com.bugraburunguz.leavemanagementservice.dto.UserAdminDto;
import com.bugraburunguz.leavemanagementservice.validation.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Api(value = "Employees")
public class UserAdminController {

    private final UserAdminService userAdminService;

    @PostMapping
    @ApiOperation(value = "Adding Employee Method")
    public ResponseEntity<UserAdminDto> create(@RequestBody UserAdminDto userAdminDto) {
        return ResponseEntity.ok(userAdminService.save(userAdminDto));
    }
    @DeleteMapping(value = "/deletePost/{id}")
    @ApiOperation(value = "Adding Employee Method")
    public ResponseEntity<Long> delete(@RequestBody Long id) {
        userAdminService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    @ApiOperation(value = "Listing Employee Method")
    public ResponseEntity<List<UserAdminDto>> listAllUser() {
        return ResponseEntity.ok(userAdminService.findAll());
    }
}
