package com.example.ADDRESSSERVICE.service.impl;

import com.example.ADDRESSSERVICE.entity.Address;
import com.example.ADDRESSSERVICE.repository.AddressRepository;
import com.example.ADDRESSSERVICE.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Address createAddress(Address address) {
        Address savedAddress = addressRepository.saveAndFlush(address);
        log.info("\nSaved address:\n"+savedAddress);
        return savedAddress;
    }

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        log.info("/naddress:"+addresses);
        return addresses;
    }

    @Override
    public Address getAddress(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        log.info("/naddress"+address.get());
        return address.get();
    }

    @Override
    public Address updateAddress(Address address) {
        Address updatedAddress = addressRepository.saveAndFlush(address);
        log.info("\nUpdated address:\n"+updatedAddress);
        return updatedAddress;
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

}
