package br.com.sennatech.wasddoquotation.controller;

import br.com.sennatech.wasddoquotation.domain.DataQuotation;
import br.com.sennatech.wasddoquotation.domain.FinalQuotationResponse;
import br.com.sennatech.wasddoquotation.domain.dto.QuotationKafkaMessage;
import br.com.sennatech.wasddoquotation.domain.dto.QuotationRequestDTO;
import br.com.sennatech.wasddoquotation.integration.KafkaProducer;
import br.com.sennatech.wasddoquotation.service.CalculateQuotation;
import br.com.sennatech.wasddoquotation.service.GeneratesQuotationCode;
import br.com.sennatech.wasddoquotation.service.GetCoverageType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.RoundingMode;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quotations")
public class QuotationController {

    private final CalculateQuotation calculateQuotation;
    private final GeneratesQuotationCode generatesQuotationCode;
    private final KafkaProducer kafkaProducer;
    private final GetCoverageType getCoverageType;


    @PostMapping
    public ResponseEntity<FinalQuotationResponse>  quotation(@Valid @RequestBody QuotationRequestDTO dataDTO) {
        String codetest = generatesQuotationCode.createCode();
        List<String> listNameCoverages = getCoverageType.getTypes(dataDTO);
        var value = calculateQuotation.quotationCalc(dataDTO).setScale(2, RoundingMode.HALF_EVEN);
        var finalQuotation = new QuotationKafkaMessage();
        finalQuotation.setData(new DataQuotation(listNameCoverages,codetest,value,dataDTO.getInsuredAddress(), dataDTO.getDocumentNumber()));
        this.kafkaProducer.send(finalQuotation);
        System.out.println(finalQuotation);
        return ResponseEntity.ok().body(new FinalQuotationResponse( listNameCoverages ,codetest,value, dataDTO.getDocumentNumber()));
    }

}
