package com.kodlamaio.rentACar2.api;

//bakıma bir araba ekliyoruz ona update ondan önce get by ıd tuttu state ordan set alıp
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.rentACar2.business.abstracts.MaintenanceService;
import com.kodlamaio.rentACar2.business.requests.Maintenance.CreateMaintenanceRequest;
import com.kodlamaio.rentACar2.business.requests.Maintenance.DeleteMaintenanceRequest;
import com.kodlamaio.rentACar2.business.requests.Maintenance.UpdateMaintenanceRequest;
import com.kodlamaio.rentACar2.business.responces.Maintenance.GetAllMaintenanceResponce;
import com.kodlamaio.rentACar2.business.responces.Maintenance.GetMaintenanceResponce;
import com.kodlamaio.rentACar2.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar2.entities.concretes.Maintenance;

@RestController
@RequestMapping("api/maintenances")
public class MaintenancesController {
	@Autowired
	private MaintenanceService maintenanceService;
	private ModelMapperService modelMapperService;

	@PostMapping("/add")

	public Result add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) {
		maintenanceService.Add(createMaintenanceRequest);
		return new SuccessResult();

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteMaintenanceRequest deleteMaintenanceRequest) {
		maintenanceService.Delete(deleteMaintenanceRequest);
		return new SuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest) {
		maintenanceService.Update(updateMaintenanceRequest);
		return new SuccessResult();

	}

	@GetMapping("/getbyid")
	public DataResult<Maintenance> getById(GetMaintenanceResponce getMaintenanceResponce) {
		return maintenanceService.getById(getMaintenanceResponce);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllMaintenanceResponce>> getAll() {
		return this.maintenanceService.getAll();
	}
}
