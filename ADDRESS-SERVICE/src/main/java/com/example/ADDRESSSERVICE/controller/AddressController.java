package com.example.ADDRESSSERVICE.controller;

import com.example.ADDRESSSERVICE.entity.Address;
import com.example.ADDRESSSERVICE.service.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Address", description = "the Address Api")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAddresses() {
        List<Address> addresses;
        try {
            addresses = addressService.getAllAddresses();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
        Address address;
        try {
            address = addressService.getAddress(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address createdAddress;
        try{
            createdAddress = addressService.createAddress(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(createdAddress);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        Address updatedAddress;
        try{
            updatedAddress = addressService.updateAddress(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        try {
            addressService.deleteAddress(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("deleted successfully");
    }
}
