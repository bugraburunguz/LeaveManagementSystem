package com.bugraburunguz.leavemanagementservice.controller;

import com.bugraburunguz.leavemanagementservice.request.LeaveRequest;
import com.bugraburunguz.leavemanagementservice.validation.ApplyLeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
@RequiredArgsConstructor
@Api(value = "Leaves")
public class ApplyLeaveController {
    private final ApplyLeaveService applyLeaveService;

    @PostMapping
    @ApiOperation(value = "Adding Leave Method")
    public ResponseEntity<Long> create(@RequestBody LeaveRequest leaveRequest) {
        return ResponseEntity.ok(applyLeaveService.create(leaveRequest));
    }

    @DeleteMapping(value = "/deletePost/{id}")
    @ApiOperation(value = "Deleting Leave Method")
    public ResponseEntity<Long> delete(@RequestBody Long id) {
        applyLeaveService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Listing Leave Method")
    public ResponseEntity<List<com.bugraburunguz.leavemanagementservice.response.LeaveResponse>> listAllUser() {
        return ResponseEntity.ok(applyLeaveService.findAll());
    }

    @ApiOperation(value = "Update Leave Method")
    @PutMapping("/{leaveId}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable final Long leaveId,
                                                 @RequestBody final LeaveRequest leaveRequest) {
        applyLeaveService.update(leaveRequest, leaveId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
