package pl.cyfrogen.nhom16_mymoney.exceptions;

public class ZeroBalanceDifferenceException extends Exception
{
    public ZeroBalanceDifferenceException(String text)
    {
        super(text);
    }
}
