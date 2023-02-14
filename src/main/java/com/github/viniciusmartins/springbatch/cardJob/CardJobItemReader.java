package com.github.viniciusmartins.springbatch.cardJob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


@Slf4j
public class CardJobItemReader implements ItemReader<String> {

    private final TypeEnum type;

    public CardJobItemReader(TypeEnum type) {
        this.type = type;
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (TypeEnum.DEFAULT.equals(type)){
            log.info("Deve buscar todos os produtos na base");
            return "Deve buscar todos os produtos na base";

        } else if (TypeEnum.TYPE_1.equals(type)) {
            log.info("Deve buscar o produto tipo 1");
            return "Deve buscar o produto tipo 1";

        } else if (TypeEnum.TYPE_2.equals(type)) {
            log.info("Deve buscar o produto tipo 2");
            return "Deve buscar o produto tipo 2";
        }
        return null;
    }
    // o processor pode ser o mesmo nesse caso provavelmente para todos os tipos, assim como o writer
    // so precisou buscar o pelo tipo de produto para separar as execuções
}
