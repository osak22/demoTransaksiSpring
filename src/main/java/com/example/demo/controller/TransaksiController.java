package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaksi;
import com.example.demo.services.TransaksiService;

@SpringBootApplication
@Controller
public class TransaksiController extends SpringBootServletInitializer {
		
	private TransaksiService transaksiService;
	
	@Autowired
	public void setTransaksiService(TransaksiService transaksiService) {
		this.transaksiService = transaksiService;
	}
	
	// menampilkan transaksi.html
	@RequestMapping("/")
	public String transaksiList(Model model) {
		model.addAttribute("transaksi", transaksiService.listTransaksi());
		return "transaksi";
	}

    // Kehalaman formtransaksi.html
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {
        model.addAttribute("transaksi", new Transaksi()); // class dr model
        return "formTransaksi";
    }
	
	// simpan
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String simpanDataTransaksi(Model model, Transaksi transaksi) {
        model.addAttribute("transaksi", transaksiService.saveOrUpdate(transaksi));
        return "redirect:/";
    }

    // edit
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model) {
        model.addAttribute("transaksi", transaksiService.getIdTransaksi(id));
        return "formTransaksi";
    }

    // hapus
    @RequestMapping(value = "/delete/{id}")
    public String hapusData(@PathVariable Integer id) {
        transaksiService.hapusIdTransaksi(id);
        return "redirect:/";
    }
}
