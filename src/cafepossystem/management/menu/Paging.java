package cafepossystem.management.menu;

import java.util.ArrayList;
import cafepossystem.data.Data;

public class Paging<T> {

	private ArrayList<T> list = new ArrayList<T>();
	
	public Paging(ArrayList<T> list) {
		this.list = list;
	}

	// 페이징
	public void pagingSample(int pageNum, int pageBlockSize) {
		
		int currentPage = pageNum; // 첫 페이지
		int pageBlock = pageBlockSize;  // 페이지 당 목록 수		
		
		while(true) {
			
			int totalPage = list.size()/pageBlock + ((list.size()%pageBlock) > 0 ? 1 : 0); // 총 페이지		
			
			int currentBlock = currentPage-1;	// 현재 목록 번호
			int startNum = currentBlock*pageBlock+1;
			int endNum = currentBlock*pageBlock + pageBlock; 
			

			for(int i=1; i<=totalPage; i++) {
			if(i>totalPage) break;
			if(i==currentPage) System.out.printf("[%d]", i);
			else System.out.printf("|%d|", i);
			}
			
			
		}
		
	} // paging sample
	
} // class
