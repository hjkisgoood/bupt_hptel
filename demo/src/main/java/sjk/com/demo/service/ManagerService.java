package sjk.com.demo.service;

import sjk.com.demo.entity.Manager;
import sjk.com.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager addManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public String generateReport() {
        // 假设生成报告的逻辑在这里实现
        return "Report generated!";
    }
}