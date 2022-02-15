package com.sevenspan.patient.controller;

import com.sevenspan.patient.dto.requestdto.TreatmentRequest;
import com.sevenspan.patient.dto.responsedto.SuccessMessage;
import com.sevenspan.patient.dto.responsedto.TreatmentResponse;
import com.sevenspan.patient.service.TreatmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/treatment")
@Log4j2
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    @GetMapping(value = "/")
    public SuccessMessage<List<TreatmentResponse>> getAllTreatment() {
        return new SuccessMessage<>(treatmentService.getAllTreatment());
    }

    @GetMapping(value = "/{id}")
    public SuccessMessage<List<TreatmentResponse>> getTreatmentsByPatientId(@PathVariable("id") Long id) {
        return new SuccessMessage<>(treatmentService.getTreatmentByPatientId(id));
    }

    @PostMapping(value = "/")
    public SuccessMessage<TreatmentResponse> createTreatment(@RequestBody TreatmentRequest treatmentDTO) {
        return new SuccessMessage<>(treatmentService.createTreatment(treatmentDTO));
    }

    @PutMapping(value = "/")
    public SuccessMessage<TreatmentResponse> updateTreatment(@RequestBody TreatmentRequest treatmentDTO) {
        return new SuccessMessage<>(treatmentService.updatetreatment(treatmentDTO));
    }
}
