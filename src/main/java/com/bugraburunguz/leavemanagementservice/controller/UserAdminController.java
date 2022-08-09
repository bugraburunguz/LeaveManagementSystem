package com.bugraburunguz.leavemanagementservice.controller;

import com.bugraburunguz.leavemanagementservice.request.UserRequest;
import com.bugraburunguz.leavemanagementservice.response.UserResponse;
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
    public ResponseEntity<Long> create(@RequestBody UserRequest userRequest) throws Exception {
        return ResponseEntity.ok(userAdminService.create(userRequest));
    }

    @DeleteMapping(value = "/deletePost/{id}")
    @ApiOperation(value = "Deleting Employee Method")
    public ResponseEntity<Long> delete(@RequestBody Long id) {
        userAdminService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Listing Employee Method")
    public ResponseEntity<List<UserResponse>> listAllUser() {
        return ResponseEntity.ok(userAdminService.findAll());
    }

    @ApiOperation(value = "Update Employee Method")
    @PutMapping("/{userId}")
    public ResponseEntity<HttpStatus> updateBanner(@PathVariable final Long userId,
                                                   @RequestBody final UserRequest userRequest) {
        userAdminService.update(userRequest, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
