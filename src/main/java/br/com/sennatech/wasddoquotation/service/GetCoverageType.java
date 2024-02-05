package br.com.sennatech.wasddoquotation.service;

import br.com.sennatech.wasddoquotation.domain.dto.QuotationRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCoverageType {
    public List<String> getTypes(QuotationRequestDTO dataDTO){
    List<String> coveragesTypes = dataDTO.getCoverages()
            .stream()
            .map(coverage -> coverage.name()).collect(Collectors.toList());
        System.out.println("sssssssssssssssssssssssssssssssssssssss");
        System.out.println(coveragesTypes);
        return coveragesTypes;
    }
}
