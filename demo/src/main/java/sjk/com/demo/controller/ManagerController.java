package sjk.com.demo.controller;

import sjk.com.demo.entity.Manager;
import sjk.com.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public Manager addManager(@RequestBody Manager manager) {
        return managerService.addManager(manager);
    }

    @GetMapping("/{id}")
    public Manager getManager(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/report")
    public String generateReport() {
        return managerService.generateReport();
    }
}