package autobazar.dto;

/**
 * Created by Andrey on 26.02.2017.
 */
public class PageDetailsDto {
    private String sort;
    private int itemsOnPage;
    private int pageNumber;
    private int amountOfPage;
    private int amountOfItems;

    public PageDetailsDto(int amountOfItems) {
        this.sort = "id";
        this.itemsOnPage = 5;
        this.pageNumber = 1;
        this.amountOfPage = (int)Math.ceil(amountOfItems/5.);
        this.amountOfItems = amountOfItems;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getItemsOnPage() {
        return itemsOnPage;
    }

    public void setItemsOnPage(int itemsOnPage) {
        this.itemsOnPage = itemsOnPage;
        setAmountOfPage(itemsOnPage);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getAmountOfPage() {
        return amountOfPage;
    }

    public void setAmountOfPage(int amountOfPage) {
        this.amountOfPage = (int)Math.ceil((double)amountOfItems/amountOfPage);
}

    public int getAmountOfItems() {
        return amountOfItems;
    }

    public void setAmountOfItems(int amountOfItems) {
        this.amountOfItems = amountOfItems;
    }
}
