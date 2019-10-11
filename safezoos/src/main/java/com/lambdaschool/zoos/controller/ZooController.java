package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    // GET: localhost:2020/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    //Endpoint 2 -> GET:localhost:2020/zoos/zoos/:{id} - returns all information related to a zoo based on its id
    @GetMapping(value = "/zoos/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> getZooById(
            @PathVariable
                    Long id)
    {
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z,
                HttpStatus.OK);
    }

    //Endpoint 3 -> GET:localhost:2020/zoos/zoos/:{name} - returns all information related to a zoo based on its full name
}
