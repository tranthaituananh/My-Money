package pl.cyfrogen.nhom16_mymoney.ui.main.statistics;

import pl.cyfrogen.nhom16_mymoney.firebase.models.Currency;
import pl.cyfrogen.nhom16_mymoney.models.Category;

public class TopCategoryStatisticsListViewModel
{
    private final float percentage;
    private long money;
    private final Currency currency;
    private final Category category;
    private String categoryName;

    public TopCategoryStatisticsListViewModel(Category category, String categoryName, Currency currency, long money, float percentage)
    {
        this.category = category;
        this.categoryName = categoryName;
        this.currency = currency;
        this.money = money;
        this.percentage = percentage;

    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public long getMoney()
    {
        return money;
    }

    public Category getCategory()
    {
        return category;
    }

    public float getPercentage()
    {
        return percentage;
    }
}
