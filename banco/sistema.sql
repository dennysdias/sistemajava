--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.4
-- Dumped by pg_dump version 9.2.4
-- Started on 2023-07-25 20:07:09

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 180 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 16462)
-- Name: cidade; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cidade (
    id integer NOT NULL,
    cidade character varying(200),
    id_estado integer
);


ALTER TABLE public.cidade OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16460)
-- Name: cidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cidade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cidade_id_seq OWNER TO postgres;

--
-- TOC entry 1996 (class 0 OID 0)
-- Dependencies: 176
-- Name: cidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cidade_id_seq OWNED BY cidade.id;


--
-- TOC entry 173 (class 1259 OID 16435)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE endereco (
    id integer NOT NULL,
    endereco character varying(200),
    numero character varying(10),
    complemento character varying(200),
    bairro character varying(100),
    cep character varying(9),
    id_estado integer,
    id_cidade integer,
    id_pessoa integer,
    id_tipo_endereco integer
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16433)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_id_seq OWNER TO postgres;

--
-- TOC entry 1997 (class 0 OID 0)
-- Dependencies: 172
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE endereco_id_seq OWNED BY endereco.id;


--
-- TOC entry 175 (class 1259 OID 16446)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estado (
    id integer NOT NULL,
    uf character varying(200),
    estado character varying(200)
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 16410)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pessoa (
    id integer NOT NULL,
    nome character varying(200) NOT NULL,
    razaosocial character varying(200),
    cpf character varying(14) NOT NULL,
    cnpj character varying(18),
    telefone character varying(14),
    email character varying(256),
    tipo_pessoa character varying(2)
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 16408)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 1998 (class 0 OID 0)
-- Dependencies: 168
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pessoa_id_seq OWNED BY pessoa.id;


--
-- TOC entry 171 (class 1259 OID 16427)
-- Name: tipo_endereco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_endereco (
    id integer NOT NULL,
    tipo_endereco character varying(50)
);


ALTER TABLE public.tipo_endereco OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16425)
-- Name: tipo_endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_endereco_id_seq OWNER TO postgres;

--
-- TOC entry 1999 (class 0 OID 0)
-- Dependencies: 170
-- Name: tipo_endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_endereco_id_seq OWNED BY tipo_endereco.id;


--
-- TOC entry 174 (class 1259 OID 16444)
-- Name: uf_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE uf_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.uf_id_seq OWNER TO postgres;

--
-- TOC entry 2000 (class 0 OID 0)
-- Dependencies: 174
-- Name: uf_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE uf_id_seq OWNED BY estado.id;


--
-- TOC entry 179 (class 1259 OID 16525)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id integer NOT NULL,
    nome character varying(200),
    login character varying(50),
    senha character varying(50),
    ativo boolean
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16523)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2001 (class 0 OID 0)
-- Dependencies: 178
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id;


--
-- TOC entry 1952 (class 2604 OID 16465)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade ALTER COLUMN id SET DEFAULT nextval('cidade_id_seq'::regclass);


--
-- TOC entry 1950 (class 2604 OID 16438)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco ALTER COLUMN id SET DEFAULT nextval('endereco_id_seq'::regclass);


--
-- TOC entry 1951 (class 2604 OID 16449)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado ALTER COLUMN id SET DEFAULT nextval('uf_id_seq'::regclass);


--
-- TOC entry 1948 (class 2604 OID 16413)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa ALTER COLUMN id SET DEFAULT nextval('pessoa_id_seq'::regclass);


--
-- TOC entry 1949 (class 2604 OID 16430)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_endereco ALTER COLUMN id SET DEFAULT nextval('tipo_endereco_id_seq'::regclass);


--
-- TOC entry 1953 (class 2604 OID 16550)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_usuario_seq'::regclass);


--
-- TOC entry 1985 (class 0 OID 16462)
-- Dependencies: 177
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cidade (id, cidade, id_estado) FROM stdin;
1	Fortaleza	1
2	Brasília	2
\.


--
-- TOC entry 2002 (class 0 OID 0)
-- Dependencies: 176
-- Name: cidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cidade_id_seq', 1, false);


--
-- TOC entry 1981 (class 0 OID 16435)
-- Dependencies: 173
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY endereco (id, endereco, numero, complemento, bairro, cep, id_estado, id_cidade, id_pessoa, id_tipo_endereco) FROM stdin;
\.


--
-- TOC entry 2003 (class 0 OID 0)
-- Dependencies: 172
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('endereco_id_seq', 10, true);


--
-- TOC entry 1983 (class 0 OID 16446)
-- Dependencies: 175
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY estado (id, uf, estado) FROM stdin;
1	CE	Ceará
2	DF	Distrito federal
\.


--
-- TOC entry 1977 (class 0 OID 16410)
-- Dependencies: 169
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pessoa (id, nome, razaosocial, cpf, cnpj, telefone, email, tipo_pessoa) FROM stdin;
\.


--
-- TOC entry 2004 (class 0 OID 0)
-- Dependencies: 168
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pessoa_id_seq', 10, true);


--
-- TOC entry 1979 (class 0 OID 16427)
-- Dependencies: 171
-- Data for Name: tipo_endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_endereco (id, tipo_endereco) FROM stdin;
1	Residencial
2	Comercial
\.


--
-- TOC entry 2005 (class 0 OID 0)
-- Dependencies: 170
-- Name: tipo_endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_endereco_id_seq', 1, false);


--
-- TOC entry 2006 (class 0 OID 0)
-- Dependencies: 174
-- Name: uf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('uf_id_seq', 1, false);


--
-- TOC entry 1987 (class 0 OID 16525)
-- Dependencies: 179
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, nome, login, senha, ativo) FROM stdin;
1	Dennys Dias Lopes	dennys	123456	t
\.


--
-- TOC entry 2007 (class 0 OID 0)
-- Dependencies: 178
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 3, true);


--
-- TOC entry 1963 (class 2606 OID 16467)
-- Name: id_cidade; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT id_cidade PRIMARY KEY (id);


--
-- TOC entry 1959 (class 2606 OID 16459)
-- Name: id_endereco; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT id_endereco PRIMARY KEY (id);


--
-- TOC entry 1955 (class 2606 OID 16457)
-- Name: id_pessoa; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT id_pessoa PRIMARY KEY (id);


--
-- TOC entry 1957 (class 2606 OID 16455)
-- Name: id_tipo_endereco; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_endereco
    ADD CONSTRAINT id_tipo_endereco PRIMARY KEY (id);


--
-- TOC entry 1961 (class 2606 OID 16451)
-- Name: id_uf; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estado
    ADD CONSTRAINT id_uf PRIMARY KEY (id);


--
-- TOC entry 1965 (class 2606 OID 16552)
-- Name: id_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT id_usuario PRIMARY KEY (id);


--
-- TOC entry 1972 (class 2606 OID 16647)
-- Name: fk672d67c9122803ee; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk672d67c9122803ee FOREIGN KEY (id_pessoa) REFERENCES pessoa(id);


--
-- TOC entry 1970 (class 2606 OID 16637)
-- Name: fk672d67c95436cb69; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk672d67c95436cb69 FOREIGN KEY (id_tipo_endereco) REFERENCES tipo_endereco(id);


--
-- TOC entry 1971 (class 2606 OID 16642)
-- Name: fk672d67c9e62c92e8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk672d67c9e62c92e8 FOREIGN KEY (id_cidade) REFERENCES cidade(id);


--
-- TOC entry 1973 (class 2606 OID 16652)
-- Name: fk672d67c9ee28576c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk672d67c9ee28576c FOREIGN KEY (id_estado) REFERENCES estado(id);


--
-- TOC entry 1975 (class 2606 OID 16632)
-- Name: fkaee65724ee28576c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT fkaee65724ee28576c FOREIGN KEY (id_estado) REFERENCES estado(id);


--
-- TOC entry 1969 (class 2606 OID 16627)
-- Name: id_cidade; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT id_cidade FOREIGN KEY (id_cidade) REFERENCES cidade(id);


--
-- TOC entry 1974 (class 2606 OID 16607)
-- Name: id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT id_estado FOREIGN KEY (id_estado) REFERENCES estado(id);


--
-- TOC entry 1968 (class 2606 OID 16622)
-- Name: id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT id_estado FOREIGN KEY (id_estado) REFERENCES estado(id);


--
-- TOC entry 1966 (class 2606 OID 16612)
-- Name: id_pessoa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT id_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id);


--
-- TOC entry 1967 (class 2606 OID 16617)
-- Name: id_tipo_endereco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT id_tipo_endereco FOREIGN KEY (id_tipo_endereco) REFERENCES tipo_endereco(id);


--
-- TOC entry 1994 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-07-25 20:07:09

--
-- PostgreSQL database dump complete
--

