package com.kodlamaio.rentACar2.business.abstracts;

import java.util.List;

import com.kodlamaio.rentACar2.business.requests.Maintenance.CreateMaintenanceRequest;
import com.kodlamaio.rentACar2.business.requests.Maintenance.DeleteMaintenanceRequest;
import com.kodlamaio.rentACar2.business.requests.Maintenance.UpdateMaintenanceRequest;
import com.kodlamaio.rentACar2.business.responces.Maintenance.GetAllMaintenanceResponce;
import com.kodlamaio.rentACar2.business.responces.Maintenance.GetMaintenanceResponce;
import com.kodlamaio.rentACar2.core.utilities.results.DataResult;
import com.kodlamaio.rentACar2.core.utilities.results.Result;
import com.kodlamaio.rentACar2.entities.concretes.Maintenance;

public interface MaintenanceService {
	Result Add(CreateMaintenanceRequest createMaintenanceRequest);

	Result Delete(DeleteMaintenanceRequest deleteMaintenanceRequest);

	Result Update(UpdateMaintenanceRequest updateMaintenanceRequest);

	DataResult<Maintenance> getById(GetMaintenanceResponce getMaintenanceResponce);

	DataResult<List<GetAllMaintenanceResponce>> getAll();
}
