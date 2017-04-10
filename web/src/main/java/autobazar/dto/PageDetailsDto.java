package autobazar.dto;

import java.util.HashMap;

/**
 * Created by Andrey on 26.02.2017.
 */
public class PageDetailsDto {
    private String sort;
    private int itemsOnPage;
    private int pageNumber;
    private int amountOfPage;
    private long amountOfItems;
    private String pageType;
    private HashMap<String,String> searchParameters;

    public PageDetailsDto(long amountOfItems) {
        this.sort = "id";
        this.itemsOnPage = 10;
        this.pageNumber = 1;
        this.amountOfPage = (int)Math.ceil(amountOfItems/10.);
        this.amountOfItems = amountOfItems;
        pageType = "items";
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
        pageNumber = 1;
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

    public long getAmountOfItems() {
        return amountOfItems;
    }

    public void setAmountOfItems(long amountOfItems) {
        this.amountOfItems = amountOfItems;
        pageNumber = 1;
        setAmountOfPage(itemsOnPage);
    }

    public HashMap<String, String> getSearchParameters() {
        return searchParameters;
    }

    public void setSearchParameters(HashMap<String, String> searchParameters) {
        this.searchParameters = searchParameters;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }
}
