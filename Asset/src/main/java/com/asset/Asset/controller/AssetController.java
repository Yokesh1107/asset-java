package com.asset.Asset.controller;

import com.asset.Asset.model.*;
import com.asset.Asset.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssetController {
    @Autowired
    SoftwareRepository softwareRepository;
    @Autowired
    VendorsRepository VendorsRepository;
    @Autowired
    DevicesRepository DevicesRepository;
    @Autowired
    StudentsRepository StudentsRepository;
    @Autowired
    DeviceSoftwareRepository DeviceSoftwareRepository;

    //Softwares CRUD
    @GetMapping("/get-all-softwares")
    public List<Softwares> getAllSoftwares(){
        return  softwareRepository.findAll();
    }
    @GetMapping("/getSoftwareById/{id}")
    public Softwares getSoftwareById(@PathVariable("id") int id){
        return softwareRepository.findById(id).get();
    }
    @GetMapping("getSoftwareByName/{name}")
    public Softwares getSoftwareByName(@PathVariable("name") String name) {
        return softwareRepository.findByName(name).orElse(null); // Using orElse(null) to handle the case where the software with the given name is not found
    }
    @PostMapping("/addSoftware")
    public ResponseEntity<?> addSoftware(@RequestBody Softwares software){
        if(softwareRepository.existsById(software.getSoftwareId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Software with id " + software.getSoftwareId() + " already exists.");
        }
        Softwares savedSoftware = softwareRepository.save(software);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSoftware);
    }
    @DeleteMapping("deleteSoftware/{id}")
    public Boolean deleteSoftware(@PathVariable("id") int id){
        if(softwareRepository.existsById(id)) {
            softwareRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @PutMapping("updateSoftware/{id}")
    public ResponseEntity<?> updateSoftware(@PathVariable("id") int id, @RequestBody Softwares software){
        if(softwareRepository.existsById(id)) {
            Softwares mySoftware = softwareRepository.findById(id).get();
            mySoftware.setSoftwareName(software.getSoftwareName());
            Softwares savedSoftware = softwareRepository.save(mySoftware);
            return ResponseEntity.status(HttpStatus.OK).body(savedSoftware);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Software with id " + id + " not found.");

    }


    //VENDORS CRUD
    @GetMapping("/get-all-vendors")
    public List<Vendors> getAllVendors(){
        return VendorsRepository.findAll();
    }
    @GetMapping("/getVendorById/{id}")
    public Vendors getVendorsById(@PathVariable("id") int id){
        return VendorsRepository.findById(id).get();
    }
    @GetMapping("/getVendorByName/{name}")
    public Vendors getVendorByName(@PathVariable("name") String name){
        return VendorsRepository.findByName(name).orElse(null);
    }
    @DeleteMapping("/deleteVendor/{id}")
    public Boolean deleteVendor(@PathVariable("id") int id){
        if(VendorsRepository.existsById(id)) {
            VendorsRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @PutMapping("/updateVendor/{id}")
    public ResponseEntity<?> updateVendor(@PathVariable("id") int id, @RequestBody Vendors vendor){
        if(VendorsRepository.existsById(id)) {
            Vendors vendors=VendorsRepository.findById(id).get();
            vendors.setVendorName(vendor.getVendorName());
            VendorsRepository.save(vendors);
            return ResponseEntity.status(HttpStatus.OK).body(vendors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor with id " + id + " not found.");
    }
    @PostMapping("/addVendor")
    public ResponseEntity<?> addVendor(@RequestBody Vendors vendor){
        if(VendorsRepository.existsById(vendor.getVendorId())) {
            return ResponseEntity.status(HttpStatus.IM_USED).body("Vendor with id " + vendor.getVendorId() + " already exists.");
        }
        Vendors savedVendor = VendorsRepository.save(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);

    }

    //DEVICES CRUD
    @GetMapping("/get-all-devices")
    public List<Devices> getAllDevices(){
        return DevicesRepository.findAll();
    }
    @GetMapping("/getDeviceById/{id}")
    public Devices getDeviceById(@PathVariable("id") int id){
        return DevicesRepository.findById(id).get();
    }
    @GetMapping("/getDeviceByName/{name}")
    public List<Devices> getDeviceByName(@PathVariable("name") String name){
        return DevicesRepository.findByName(name).orElse(null);
    }
    @DeleteMapping("/deleteDevice/{id}")
    public Boolean deleteDevice(@PathVariable("id") int id){
        if(DevicesRepository.existsById(id)) {
            DevicesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @PutMapping("updateDevice/{id}")
    public ResponseEntity<?> updateDevice(@PathVariable("id") int id, @RequestBody Devices device){
        if(DevicesRepository.existsById(id)) {
            Devices savedDevice = DevicesRepository.findById(id).get();
            savedDevice.setDeviceName(device.getDeviceName());
            DevicesRepository.save(savedDevice);
            return ResponseEntity.status(HttpStatus.OK).body(savedDevice);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Device with id " + id + " not found.");
    }
    @PostMapping("addDevice")
    public ResponseEntity<?> addDevice(@RequestBody Devices device){
        if(DevicesRepository.existsById(device.getDeviceId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Device with id " + device.getDeviceId() + " already exists.");
        }
        Devices savedDevice = DevicesRepository.save(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDevice);
    }


    //STUDENTS CRUD
    @GetMapping("/get-all-students")
    public List<Students> getAllStudents(){
        return StudentsRepository.findAll();
    }
    @GetMapping("/getStudentById/{id}")
    public Students getStudentById(@PathVariable("id") int id){
        return StudentsRepository.findById(id).get();
    }
    @GetMapping("/getStudentByName/{name}")
    public List<Students> getStudentByName(@PathVariable("name") String name){
        return StudentsRepository.findByName(name).orElse(null);
    }
    @DeleteMapping("deleteStudent/{id}")
    public Boolean deleteStudent(@PathVariable("id") int id){
        if(StudentsRepository.existsById(id)) {
            StudentsRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @PutMapping("updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @RequestBody Students student){
        if(StudentsRepository.existsById(id)) {
            Students savedStudent = StudentsRepository.findById(id).get();
            savedStudent.setStudentName(student.getStudentName());
            StudentsRepository.save(savedStudent);
            return ResponseEntity.status(HttpStatus.OK).body(savedStudent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + " not found.");
    }
    @PostMapping("addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Students student){
        if(StudentsRepository.existsById(student.getStudentId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student with id " + student.getStudentId() + " already exists.");
        }
        Students savedStudent = StudentsRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    //ADDING SOFTWARE TO VENDORS
    @PutMapping("/addSoftwareToVendor")
    public boolean addSoftwareToVendor(@RequestBody addSoftwareToVendor obj){
        if(softwareRepository.existsById(obj.getSoftwareId())) {
            Softwares software= softwareRepository.findById(obj.getSoftwareId()).get();
            software.setVendorId(obj.getVendorId());
            softwareRepository.save(software);
            return true;
        }
        return false;
    }

    //ADDING SOFTWARE TO DEVICE
    @PostMapping("/addSoftwareToDevice")
    public ResponseEntity<?> addSoftwareToDevice(@RequestBody addSoftwareToDevice std){
        if(DeviceSoftwareRepository.checkExists(std.getDeviceId(), std.getSoftwareId()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Software with id " + std.getSoftwareId() +"already installed in Device with id "+ std.getDeviceId());
        }
        addSoftwareToDevice newStd=DeviceSoftwareRepository.save(std);
        return ResponseEntity.status(HttpStatus.OK).body(newStd);
    }

    //ADDING DEVICE TO STUDENT
    @PutMapping("/addDeviceToStudent")
    public ResponseEntity<?> addDeviceToStudent(@RequestBody addDeviceToStudent dts){
        if(DevicesRepository.existsById(dts.getDeviceId())) {
            Devices device=DevicesRepository.findById(dts.getDeviceId()).get();
            device.setStudentid(dts.getStudentId());
            DevicesRepository.save(device);
            return ResponseEntity.status(HttpStatus.OK).body(device);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Device with id " + dts.getDeviceId() + " not found.");
    }

    //SOFTWARE QUERIES
    @GetMapping("/getSoftwares")
    public List<Softwares> getAllSoftware(@RequestParam(required = false) Integer vendorid,@RequestParam(required = false) Integer deviceid,@RequestParam(required = false) Integer studentid){
        List<Softwares> s1=new ArrayList<>();
        if(deviceid!=null){
            s1= softwareRepository.findByDeviceId(deviceid);
        }else if(vendorid!=null){
            s1= softwareRepository.findVendorId(vendorid);
        }else if(studentid!=null){
            s1=softwareRepository.findByStudentId(studentid);
        }
        else{
            s1= softwareRepository.findAllSoftwares();
        }
        return s1;
    }

    //DEVICE QUERIES
    @GetMapping("/findDevices")
    public List<Devices> getAllDevice(@RequestParam(required = false) Integer studentid,@RequestParam(required = false) Integer softwareid){
        List<Devices> s1=new ArrayList<>();
        if(softwareid!=null){
            s1=DevicesRepository.findBySoftwareId(softwareid);
        }else if(studentid!=null){
            s1=DevicesRepository.findByStudentId(studentid);
        }else{
            s1=DevicesRepository.findAllDeviceNames();
        }
        return s1;
    }

    @GetMapping("/findStudents")
    public List<Students> getAllStudent(@RequestParam(required = false) Integer softwareid,@RequestParam(required = false) Integer deviceid){
        List<Students> s1=new ArrayList<>();
        if(softwareid!=null){
            s1=StudentsRepository.findBySoftwareId(softwareid);
        }else if(deviceid!=null){
            s1=StudentsRepository.findByDeviceId(deviceid);
        }else{
            s1=StudentsRepository.findAll();
        }
        return s1;
    }

}
