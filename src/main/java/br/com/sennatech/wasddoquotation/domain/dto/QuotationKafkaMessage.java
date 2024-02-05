package br.com.sennatech.wasddoquotation.domain.dto;

import br.com.sennatech.wasddoquotation.domain.DataQuotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuotationKafkaMessage {
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
    String operation = "COTACAO" ;
    String domain = "SEGURO";
    String origin = "ASSEGURAÊ";
    DataQuotation data;
    String documentNumber;
}
