package com.sagnik.NewBackend_Practice.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Company updated Successfully",HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String > addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created Successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company Not Deleted",HttpStatus.NOT_FOUND);
        }
    }
}
