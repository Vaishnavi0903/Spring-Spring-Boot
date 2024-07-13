package com.infosys.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("shoppingList")
public class ShoppingList {
          private List<Mobile> items = new ArrayList();
}
