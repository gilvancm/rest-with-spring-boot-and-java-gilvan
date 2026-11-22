package br.com.gilvanmuniz.exception;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.naming.StringManager;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String Manager, String details) {}

//este classe record vai ficar responsável de receber e armazenar um JSON
