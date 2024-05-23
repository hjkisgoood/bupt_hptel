package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjk.com.demo.entity.Bill;
import sjk.com.demo.service.BillService;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping
    public Bill addBill(@RequestBody Bill bill) {
        return billService.addBill(bill);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/customer/{customerId}")
    public List<Bill> getBillsByCustomerId(@PathVariable Long customerId) {
        return billService.getBillsByCustomerId(customerId);
    }
}
