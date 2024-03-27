package com.rubbypaper.demo;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.madgag.gif.fmsware.GifDecoder;

import CBFilter.CBFilterSimulation;
import CBFilter.CBFilterSimulation.ColorBlindType;
import jakarta.servlet.http.HttpServletRequest;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class CBFilterMain {

	static String imagePath ;        
	static int colorBlindTypeIndex ;


	//이미지 업로드 경로 설정 (스크린샷으로 경로 고정)
	@Value("${file.upload.directory}")
	private String sfilePath;

	@PostMapping("/filter")
	public String Methodnum(HttpServletRequest request, @RequestParam("chooseFile") MultipartFile chooseFile,RedirectAttributes redirectAttributes)
	{					
		//파일 이름 가져오는 부분
		String imgName = chooseFile.getOriginalFilename();
		redirectAttributes.addAttribute("imageName", imgName);

		//변환된 파일들을 저장할 폴더 생성여부 체크
		String savePath = "D:\\CBFilter\\convert";
		File folderdir = new File(savePath);

		if(folderdir.exists() == false)
		{
			folderdir.mkdirs();
		}
		
		//이미지 파일 값을 받는 곳
		imagePath = sfilePath + imgName;   

		//적색맹,녹색맹,청색맹 선택한 값 받아 오는 곳
		colorBlindTypeIndex = Integer.parseInt(request.getParameter("Colorblindnesstype"));  

		System.out.println("경로 테스트 : " + imagePath);

		// 입력된 색맹 유형에 해당하는 열거형 상수를 얻습니다.
		ColorBlindType colorBlindType = getColorBlindTypeByIndex(colorBlindTypeIndex);


		try {
			// 이미지 파일을 읽어옵니다.

			File imageFile = new File(imagePath);    


			//파일 권환 설정
			//imageFile.setWritable(true);
			//imageFile.setReadable(true);

			//권환 설정 확인
			//System.out.println("읽기 권환 학인하기 : " + imageFile.canRead());
			//System.out.println("쓰기 권환 학인하기 : " + imageFile.canWrite());
			//System.out.println("파일 존재 여부 확인 : " + imageFile.exists());      


			// GIF 파일인지 확인
			if (imageFile.getName().toLowerCase().endsWith(".gif")) {
				// GIF 파일 디코딩
				GifDecoder decoder = new GifDecoder();
				decoder.read(new FileInputStream(imageFile));

				List<BufferedImage> frames = new ArrayList<>();

				for (int i = 0; i < decoder.getFrameCount(); i++) {
					BufferedImage frame = decoder.getFrame(i);
					BufferedImage simulatedFrame = CBFilterSimulation.simulateColorBlindness(frame, colorBlindType);
					frames.add(simulatedFrame);
				}

				// 새로운 GIF 이미지 생성
				String outputImagePath = "src/main/resources/static/img/convert/" + imageFile.getName();
//				String outputImagePath =  savePath+ "\\" + imageFile.getName();
				createGifFromFrames(frames, outputImagePath);

				System.out.println("GIF 이미지 변환이 완료되었습니다.");

				//변환된 사진 출력 (단,convert 눌렀을 시 바로 이미지 변환 후 저장되는게 아니라서 바로는 못 찾음)
				return "redirect:/img/convert/{imageName}";
//				return outputImagePath;


			} else if(imageFile.getName().endsWith(".jpg") || imageFile.getName().endsWith(".png")) {
				// GIF가 아닌 경우 일반 이미지 변환
				BufferedImage originalImage = ImageIO.read(imageFile);

				// 색맹 시뮬레이션을 적용한 이미지 생성
				BufferedImage simulatedImage = CBFilterSimulation.simulateColorBlindness(originalImage, colorBlindType);
//				String outputImagePath =  savePath+"\\"+ imageFile.getName();
				// 이미지 저장           
				String outputImagePath = "src/main/resources/static/img/convert/"+imageFile.getName();
				ImageIO.write(simulatedImage, "png", new File(outputImagePath));

	               

	               System.out.println("이미지 변환이 완료되었습니다.");
	               
	               //변환된 사진 출력 (단,convert 눌렀을 시 바로 이미지 변환 후 저장되는게 아니라서 바로는 못 찾음)
	               return "redirect:/img/convert/{imageName}";
//				System.out.println("이미지 변환이 완료되었습니다.");   
//				System.out.println("이미지 아웃풋 출력 : " + outputImagePath);
//
//				//이미지 이름 Encoder
//				String encodedParam = URLEncoder.encode(imageFile.getName(),"UTF-8");
//
//				//변환된 사진 출력 (단,convert 눌렀을 시 바로 이미지 변환 후 저장되는게 아니라서 바로는 못 찾음)
//				return "redirect:D:\\CBFilter\\convert\\"+"{imageName}";
			}
			//다른 유형의 파일 업로드시 경고 창
			else {	
				return "/alert";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	// 숫자로 입력된 색맹 유형을 열거형 상수로 변환
	private static ColorBlindType getColorBlindTypeByIndex(int index) {
		switch (index) {
		case 1:            	
			System.out.println("여긴 적색맹 : " + colorBlindTypeIndex);
			return ColorBlindType.PROTANOPIA; //적색맹
		case 2:
			System.out.println("여긴 녹색맹 : " + colorBlindTypeIndex);
			return ColorBlindType.DEUTERANOPIA; //녹색맹
		case 3:
			System.out.println("여긴 청색맹 : " + colorBlindTypeIndex);
			return ColorBlindType.TRITANOPIA; //청색맹
		default:
			System.out.println("여긴 기본값이야 : " + colorBlindTypeIndex);
			return ColorBlindType.PROTANOPIA; // 기본값은 적색맹
		}
	}

	// 디코딩된 프레임들을 이용하여 GIF 이미지 생성
	private static void createGifFromFrames(List<BufferedImage> frames, String outputPath) {
		AnimatedGifEncoder encoder = new AnimatedGifEncoder();

		// 출력 경로 설정
		encoder.start(outputPath);
		encoder.setRepeat(0); // 반복 설정 (0은 무한 반복)

		for (BufferedImage frame : frames) {
			encoder.setDelay(100); // 각 프레임 간의 딜레이 (100ms)
			encoder.addFrame(frame);
		}

		encoder.finish();
	}
}
