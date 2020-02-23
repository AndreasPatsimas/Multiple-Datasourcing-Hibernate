package gr.icap.internal.shortbsparser.convert;

import gr.icap.internal.shortbsparser.dto.BalanceSheetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.File;

@Slf4j
public class BalanceSheetXmlToBalanceSheetDtoConverter {

    public static BalanceSheetDto convert(File xmlFile){

        Element element = getElement(xmlFile);

        return buildBalanceSheetDto(element, xmlFile.getName().substring(0, xmlFile.getName().length() - 4));
    }

    private static Element getElement(File xmlFile){

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            log.info("Root element :" + doc.getDocumentElement().getNodeName() + " for file: " +
                    xmlFile.getAbsolutePath());

            NodeList nList = doc.getElementsByTagName("_ΙΣΟΛΟΓΙΣΜΟΣ:_ΙΣΟΛΟΓΙΣΜΟΣ");

            Node nNode = nList.item(0);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) nNode;

                return element;
            }
        }

        catch (Exception ex){

            ex.printStackTrace();
        }

        return null;
    }

    private static BalanceSheetDto buildBalanceSheetDto(Element element, String fileName){

        return BalanceSheetDto.builder()
                .fileName(fileName)
                .corporateUse(setValue(element.getElementsByTagName("_Etairiki_xrisi").item(0)))
                .from(setValue(element.getElementsByTagName("_Apo").item(0)))
                .to(setValue(element.getElementsByTagName("_Eos").item(0)))
                .assetsYear(setValue(element.getElementsByTagName("_Etos_energitikou").item(0)))
                .fixed(setValue(element.getElementsByTagName("_Pagia").item(0)))
                .depreciated(setValue(element.getElementsByTagName("_Aposveusmena").item(0)))
                .inventories(setValue(element.getElementsByTagName("_Apothemata").item(0)))
                .requirements(setValue(element.getElementsByTagName("_Apaitiseis").item(0)))
                .advances(setValue(element.getElementsByTagName("_Prokatavoles").item(0)))
                .cashAvailable(setValue(element.getElementsByTagName("_Tameiaka_diathesima").item(0)))
                .others(setValue(element.getElementsByTagName("_Loipa").item(0)))
                .totalAssets(setValue(element.getElementsByTagName("_Sunolo_energitikou").item(0)))
                .fundsAndReserves(setValue(element.getElementsByTagName("_Kefalaia_kai_apothematika").item(0)))
                .longTermLiabilities(setValue(element.getElementsByTagName("_Makroprothesmes_upoxreoseis").item(0)))
                .shortTermLiabilities(setValue(element.getElementsByTagName("_Braxuprothesmes_upoxreoseis").item(0)))
                .totalPaymentsAndLiabilities(setValue(element.getElementsByTagName("_Sunolo_katharis_thesis_kai_upoxreoseon")
                        .item(0)))
                .resultsYear(setValue(element.getElementsByTagName("_Etos_apotelesmaton").item(0)))
                .operationsCircle(setValue(element.getElementsByTagName("_Kuklos_ergasion").item(0)))
                .otherNormalRevenue(setValue(element.getElementsByTagName("_Loipa_sunithi_esoda").item(0)))
                .incomeFromPropertyUse(setValue(element.getElementsByTagName("_Esoda_apo_idioxrisimopoiisi_akiniton")
                        .item(0)))
                .inventoryChanges(setValue(element.getElementsByTagName("_Metavoles_apothematon").item(0)))
                .markets(setValue(element.getElementsByTagName("_Agores_emporeumaton_kai_aulon").item(0)))
                .benefitsOfWorkers(setValue(element.getElementsByTagName("_Paroxes_se_ergazomenous").item(0)))
                .depreciation(setValue(element.getElementsByTagName("_Aposveseis").item(0)))
                .otherCostsAndLosses(setValue(element.getElementsByTagName("_Loipa_exoda_kai_zimies").item(0)))
                .otherRevenueAndProfits(setValue(element.getElementsByTagName("_Loipa_esoda_kai_kerdi").item(0)))
                .interestAndRelatedFunds(setValue(element.getElementsByTagName("_Tokoi_kai_sunafi_kondulia").item(0)))
                .resultsBeforeTaxes(setValue(element.getElementsByTagName("_Apotelsemata_pro_foron").item(0)))
                .taxes(setValue(element.getElementsByTagName("_Foroi").item(0)))
                .periodAfterResultsFullFrames(setValue(element.getElementsByTagName("_Apotelesmata_periodou_meta_apo_forous")
                        .item(0)))

                .assetsYear1(setValue(element.getElementsByTagName("_Etos_energitikou1").item(0)))
                .fixed1(setValue(element.getElementsByTagName("_Pagia1").item(0)))
                .depreciated1(setValue(element.getElementsByTagName("_Aposveusmena1").item(0)))
                .inventories1(setValue(element.getElementsByTagName("_Apothemata1").item(0)))
                .requirements1(setValue(element.getElementsByTagName("_Apaitiseis1").item(0)))
                .advances1(setValue(element.getElementsByTagName("_Prokatavoles1").item(0)))
                .cashAvailable1(setValue(element.getElementsByTagName("_Tameiaka_diathesima1").item(0)))
                .others1(setValue(element.getElementsByTagName("_Loipa1").item(0)))
                .totalAssets1(setValue(element.getElementsByTagName("_Sunolo_energitikou1").item(0)))
                .fundsAndReserves1(setValue(element.getElementsByTagName("_Kefalaia_kai_apothematika1").item(0)))
                .longTermLiabilities1(setValue(element.getElementsByTagName("_Makroprothesmes_upoxreoseis1").item(0)))
                .shortTermLiabilities1(setValue(element.getElementsByTagName("_Braxuprothesmes_upoxreoseis1").item(0)))
                .totalPaymentsAndLiabilities1(setValue(element.getElementsByTagName("_Sunolo_katharis_thesis_kai_upoxreoseon1")
                        .item(0)))
                .resultsYear1(setValue(element.getElementsByTagName("_Etos_apotelesmaton1").item(0)))
                .operationsCircle1(setValue(element.getElementsByTagName("_Kuklos_ergasion1").item(0)))
                .otherNormalRevenue1(setValue(element.getElementsByTagName("_Loipa_sunithi_esoda1").item(0)))
                .incomeFromPropertyUse1(setValue(element.getElementsByTagName("_Esoda_apo_idioxrisimopoiisi_akiniton1")
                        .item(0)))
                .inventoryChanges1(setValue(element.getElementsByTagName("_Metavoles_apothematon1").item(0)))
                .markets1(setValue(element.getElementsByTagName("_Agores_emporeumaton_kai_aulon1").item(0)))
                .benefitsOfWorkers1(setValue(element.getElementsByTagName("_Paroxes_se_ergazomenous1").item(0)))
                .depreciation1(setValue(element.getElementsByTagName("_Aposveseis1").item(0)))
                .otherCostsAndLosses1(setValue(element.getElementsByTagName("_Loipa_exoda_kai_zimies1").item(0)))
                .otherRevenueAndProfits1(setValue(element.getElementsByTagName("_Loipa_esoda_kai_kerdi1").item(0)))
                .interestAndRelatedFunds1(setValue(element.getElementsByTagName("_Tokoi_kai_sunafi_kondulia1").item(0)))
                .resultsBeforeTaxes1(setValue(element.getElementsByTagName("_Apotelsemata_pro_foron1").item(0)))
                .taxes1(setValue(element.getElementsByTagName("_Foroi1").item(0)))
                .periodAfterResultsFullFrames1(setValue(element.getElementsByTagName("_Apotelesmata_periodou_meta_apo_forous1")
                        .item(0)))
                .build();
    }

    private static String setValue(Node item){

        String textContent = !ObjectUtils.isEmpty(item) ? item.getTextContent() : null;

        if(textContent != null && textContent.equals(""))
            textContent = null;

        return textContent;
    }
}
