/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacion_bogota;

import com.mycompany.sublimacion_bogota.dao.*;
import com.mycompany.sublimacion_bogota.modelo.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // ====== USUARIO ======
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = new Usuario(0, "Juan", "Reyes", "juan@correo.com", "1234");
        usuarioDAO.insertarUsuario(u);
        for (Usuario usr : usuarioDAO.listarUsuarios()) {
            System.out.println("Usuario: " + usr.getNombreUsuario());
        }

        // ====== PEDIDO ======
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido p = new Pedido(0, new Date(), "Pendiente", "Alta", new Date(), 1, 1, 1);
        pedidoDAO.insertarPedido(p);
        for (Pedido ped : pedidoDAO.listarPedidos()) {
            System.out.println("Pedido: " + ped.getIdPedido() + " - " + ped.getEstadoPedido());
        }

        // ====== PRODUCCIÓN ======
        ProduccionDAO produccionDAO = new ProduccionDAO();
        Produccion prod = new Produccion(0, new Date(), new Date(), "En proceso", 1);
        produccionDAO.insertarProduccion(prod);
        for (Produccion pr : produccionDAO.listarProducciones()) {
            System.out.println("Producción: " + pr.getIdProduccion() + " - Estado: " + pr.getEstadoProduccion());
        }

        // ====== TAREA PRODUCCIÓN ======
        TareaProduccionDAO tareaDAO = new TareaProduccionDAO();
        TareaProduccion t = new TareaProduccion(0, "Impresión inicial", "Pendiente", 10.0, 1, 1);
        tareaDAO.insertarTarea(t);
        for (TareaProduccion tp : tareaDAO.listarTareas()) {
            System.out.println("Tarea: " + tp.getIdTarea() + " - Estado: " + tp.getEstadoTarea());
        }

        // ====== FACTURA ======
        FacturaDAO facturaDAO = new FacturaDAO();
        Factura f = new Factura(0, "Generada", new Date(), new Date(), 1);
        facturaDAO.insertarFactura(f);
        for (Factura fac : facturaDAO.listarFacturas()) {
            System.out.println("Factura: " + fac.getIdFactura() + " - Estado: " + fac.getEstadoFactura());
        }

        // ====== INVENTARIO MOVIMIENTO ======
        InventarioMovimientoDAO movDAO = new InventarioMovimientoDAO();
        InventarioMovimiento m = new InventarioMovimiento(0, "Entrada", 50.0, "Tela blanca", 1);
        movDAO.insertarMovimiento(m);
        for (InventarioMovimiento mov : movDAO.listarMovimientos()) {
            System.out.println("Movimiento: " + mov.getIdMovimiento() + " - Tipo: " + mov.getTipoMovimiento());
        }

        // ====== INSUMOS ======
        InsumosDAO insumoDAO = new InsumosDAO();
        Insumos ins = new Insumos(0, "Tinta negra", 5000.0, 100, 7000.0, 1);
        insumoDAO.insertarInsumo(ins);
        for (Insumos i : insumoDAO.listarInsumos()) {
            System.out.println("Insumo: " + i.getNombreInsumo() + " - Stock: " + i.getStockInsumo());
        }

        // ====== DETALLE PEDIDO ======
        DetallePedidoDAO detalleDAO = new DetallePedidoDAO();
        DetallePedido d = new DetallePedido(0, 10.0, 2000.0, 5000.0, 25000.0, 1, 1, 1);
        detalleDAO.insertarDetalle(d);
        for (DetallePedido dp : detalleDAO.listarDetalles()) {
            System.out.println("Detalle: " + dp.getIdDetalle() + " - Subtotal: " + dp.getSubtotalPedido());
        }

        // ====== REPORTE ======
        ReporteDAO reporteDAO = new ReporteDAO();
        Reporte r = new Reporte(0, "Producción", new Date(), 1);
        reporteDAO.insertarReporte(r);
        for (Reporte rep : reporteDAO.listarReportes()) {
            System.out.println("Reporte: " + rep.getIdReporte() + " - Tipo: " + rep.getTipoReporte());
        }
    }
}