package com.test.insourcetake2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class OrderDetails  {
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("category_id")
    @Expose
    private var categoryId: Int = 0
    @SerializedName("free_time")
    @Expose
    private var freeTime: String? = null

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getCategoryId(): Int {
        return categoryId
    }

    fun setCategoryId(categoryId: Int) {
        this.categoryId = categoryId
    }

    fun getFreeTime(): String? {
        return freeTime
    }

    fun setFreeTime(freeTime: String) {
        this.freeTime = freeTime
    }
}