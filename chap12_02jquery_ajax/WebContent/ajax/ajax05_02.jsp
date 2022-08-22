<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%
	// 응답 컨텐츠 타입 설정
	//이런 형태로 보내겠다고 선언
	response.setContentType("application/json");
	response.setHeader("Content-Disposiont", "inline");
	
	String[] soccer = {"축구공", "축구장", "잔듸", "손흥민", "호날두", "메시"};
	String[] swimming = {"수영장", "수영복", "물", "배영", "접영", "장태환"};
	String[] gaming = {"배틀그라운드", "리니지", "게임방", "그래픽카드", "PC방"};
	
	String[] searchType = null;
	
	if(request.getParameter("searchType[]") != null){
		searchType = request.getParameterValues("searchType[]");
	}

	List<String> list = new ArrayList<String>();

	//넘겨받은 관심 종목의 갯수 만큼 반복(1-축구/2-수영/3-게임)
	for(String type : searchType){
		
		if(type.equals("1")){			//축구
			//soccer 배열에 있는 값을 ArrayList에 담는다.
			for(int i=0; i<soccer.length; i++){
				list.add("<option>" + soccer[i] + "</option>");		
			}
		}else if(type.equals("2")){		//수영
			//swimming 배열에 있는 값을 ArrayList에 담는다.
			for(int i=0; i<swimming.length; i++){
				list.add("<option>" + swimming[i] + "</option>");		
			}
		}else if(type.equals("3")){	//게임
			//gaming 배열에 있는 값을 ArrayList에 담는다.
			for(int i=0; i<gaming.length; i++){
				list.add("<option>" + gaming[i] + "</option>");		
			}		
		}
	}
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("list", list);
	
	Gson gson = new Gson();
	String Json = gson.toJson(map);
	
	System.out.println(Json);
	
	out.println(Json);
	
%>
