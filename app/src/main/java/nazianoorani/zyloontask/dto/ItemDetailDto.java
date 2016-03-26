package nazianoorani.zyloontask.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nazianoorani on 26/03/16.
 */
public class ItemDetailDto implements Parcelable{
    private String itemName;
    private int itemImage;
    private double itemRating;

    public ItemDetailDto(){}

    public ItemDetailDto(String itemName ,int itemImage ,double itemRating){
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemRating = itemRating;
    }


    protected ItemDetailDto(Parcel in) {
        itemName = in.readString();
        itemImage = in.readInt();
        itemRating = in.readInt();
    }

    public static final Creator<ItemDetailDto> CREATOR = new Creator<ItemDetailDto>() {
        @Override
        public ItemDetailDto createFromParcel(Parcel in) {
            ItemDetailDto itemDetailDto = new ItemDetailDto();
            itemDetailDto.itemName = in.readString();
            itemDetailDto.itemImage = in.readInt();
            itemDetailDto.itemRating = in.readDouble();
            return itemDetailDto;
        }

        @Override
        public ItemDetailDto[] newArray(int size) {
            return new ItemDetailDto[size];
        }
    };

    public double getItemRating() {
        return itemRating;
    }

    public void setItemRating(double itemRating) {
        this.itemRating = itemRating;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeInt(itemImage);
        dest.writeDouble(itemRating);
    }
}
