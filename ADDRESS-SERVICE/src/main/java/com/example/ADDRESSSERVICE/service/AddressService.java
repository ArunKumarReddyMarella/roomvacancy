package com.example.ADDRESSSERVICE.service;

import com.example.ADDRESSSERVICE.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddresses();

    public Address getAddress(Integer id);

    public Address createAddress(Address address);

    public void deleteAddress(Integer id);
    public Address updateAddress(Address address);
}
