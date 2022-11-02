package google.drive.infra;

import google.drive.domain.*;
import google.drive.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashBoardViewHandler {


    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1 (@Payload FileUploaded fileUploaded) {
        try {

            if (!fileUploaded.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setId(fileUploaded.getId());
            dashBoard.setFileSize(fileUploaded.getSize());
            dashBoard.setFileName(fileUploaded.getName());
            dashBoard.setIsUploaded(true);
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenIndexed_then_UPDATE_1(@Payload Indexed indexed) {
        try {
            if (!indexed.validate()) return;
                // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(indexed.getFileId());

            if( dashBoardOptional.isPresent()) {
                 DashBoard dashBoard = dashBoardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setIsIndexed(true);    
                // view 레파지 토리에 save
                 dashBoardRepository.save(dashBoard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProcessed_then_UPDATE_2(@Payload VideoProcessed videoProcessed) {
        try {
            if (!videoProcessed.validate()) return;
                // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(Long.valueOf(videoProcessed.getFileKey()));

            if( dashBoardOptional.isPresent()) {
                 DashBoard dashBoard = dashBoardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setVideoUrl(videoProcessed.getVideoUrl());    
                // view 레파지 토리에 save
                 dashBoardRepository.save(dashBoard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

