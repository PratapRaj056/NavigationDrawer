package com.prs.pratap.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolsFragment extends Fragment {


    public ToolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);

        final ArrayList<Product> arrayList = new ArrayList<>();

        Product p1 = new Product("Coke", 100, 35);
        Product p2 = new Product("Pepsi", 145, 33);
        Product p3 = new Product("Mirinda", 144, 37);
        Product p4 = new Product("7up", 123, 32);
        Product p5 = new Product("Limca", 111, 21);
        Product p6 = new Product("Thumps Up", 160, 34.50);
        Product p7 = new Product("Thumps Up", 180, 34.50);
        Product p8 = new Product("Thumps Up", 190, 34.50);
        Product p9 = new Product("Thumps Up", 140, 34.50);
        Product p10 = new Product("Thumps Up", 130, 34.50);
        Product p11 = new Product("Thumps Up", 120, 34.50);
        Product p12 = new Product("Thumps Up", 110, 34.50);

        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        arrayList.add(p5);
        arrayList.add(p6);
        arrayList.add(p7);
        arrayList.add(p8);
        arrayList.add(p9);
        arrayList.add(p10);
        arrayList.add(p11);
        arrayList.add(p12);

        BindDictionary<Product> bindDictionary = new BindDictionary<>();
        bindDictionary.addStringField(R.id.name, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.getName();
            }
        });
        bindDictionary.addStringField(R.id.quantity, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return ""+product.getQuantity();
            }
        });
        bindDictionary.addStringField(R.id.price, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return ""+product.getPrice();
            }
        });

        FunDapter funDapter = new FunDapter(ToolsFragment.this.getActivity(), arrayList, R.layout.product_layout, bindDictionary);

        //ArrayAdapter<Product> arrayAdapter = new ArrayAdapter<Product>(ToolsFragment.this.getActivity(), android.R.layout.simple_list_item_1, arrayList);

        ListView productList = (ListView)view.findViewById(R.id.product_list);
        productList.setAdapter(funDapter);
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product selectedProduct = arrayList.get(i);
                Toast.makeText(ToolsFragment.this.getActivity(), selectedProduct.getName()+ " = " + selectedProduct.getQuantity()*selectedProduct.getPrice(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
