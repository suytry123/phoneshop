package com.java.school.PhoneShop.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {
	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private long totalElements;
	private long numberOfElements;

	private boolean empty;
	private boolean first;
	private boolean last;
}
