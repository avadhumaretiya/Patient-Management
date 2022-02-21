package com.sevenspan.patient.service;

import com.sevenspan.patient.dto.requestdto.patientdto.PatientFilterRequest;
import com.sevenspan.patient.dto.requestdto.patientdto.PatientRequest;
import com.sevenspan.patient.dto.responsedto.PatientResponse;
import com.sevenspan.patient.exceptions.PMRecordExistsException;
import com.sevenspan.patient.exceptions.PMRecordNotExistsException;
import com.sevenspan.patient.exceptions.PMSchedulerJobFailed;

import java.util.List;

public interface PatientService {

    public List<PatientResponse> getAllPatients() throws PMRecordNotExistsException;

    public PatientResponse getPatientById(String xId) throws PMRecordNotExistsException;

    public List<PatientResponse> getPatientByDoctorXid(String doctorXid, Integer pageNumber, Integer pageSize, String sortBy) throws PMRecordNotExistsException;

    public List<PatientResponse> getPatientByGivenFilter(PatientFilterRequest patientFilterDTO) throws PMRecordNotExistsException;

    public List<PatientResponse> getPatientByPhoneNumberAndEmail(Long phoneNumber, String email) throws PMRecordNotExistsException;

    public List<PatientResponse> getPatientByEmailEndsWith(String emailEnd) throws PMRecordNotExistsException;

    public List<PatientResponse> getPatientByEmailAddress(String email) throws PMRecordNotExistsException;

    public List<PatientResponse> getPatientByAgeLessThan(Integer age) throws PMRecordNotExistsException;

    public PatientResponse createPatient(PatientRequest patientRequestDTO) throws PMRecordExistsException;

    public PatientResponse updatePatient(PatientRequest patientRequestDTO) throws PMRecordNotExistsException;

    public void deletePatient(String xId);

    public void updateStatusRequestInactive(String xid) throws PMRecordNotExistsException;

    public void updateStatusInactive() throws PMSchedulerJobFailed;


}
