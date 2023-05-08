package dto;

public class PaginationSortRequestDTO {
    private PaginationInfoDTO paginationInfoDTO;
    private SortInfoDTO sortInfoDTO;

    public PaginationInfoDTO getPaginationInfoDTO() {
        return paginationInfoDTO;
    }

    public void setPaginationInfoDTO(PaginationInfoDTO paginationInfoDTO) {
        this.paginationInfoDTO = paginationInfoDTO;
    }

    public SortInfoDTO getSortInfoDTO() {
        return sortInfoDTO;
    }

    public void setSortInfoDTO(SortInfoDTO sortInfoDTO) {
        this.sortInfoDTO = sortInfoDTO;
    }
}
