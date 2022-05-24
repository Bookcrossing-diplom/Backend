--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: bookuser
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO bookuser;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: users; Type: TABLE; Schema: public; Owner: bookuser
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    firstname character varying(20) NOT NULL,
    lastname character varying(40) NOT NULL,
    login character varying(40) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE public.users OWNER TO bookuser;

--
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: bookuser
--

CREATE SEQUENCE public.user_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_user_id_seq OWNER TO bookuser;

--
-- Name: user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bookuser
--

ALTER SEQUENCE public.user_user_id_seq OWNED BY public.users.user_id;


--
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: bookuser
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: bookuser
--

COPY public.users (user_id, firstname, lastname, login, password, email) FROM stdin;
1	Илья	Кузнецов	ikyz9	123456	ikyz9@gmail.com
2	Денис	Рыжиков	den.riz	123	den@yandex.ru
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: bookuser
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bookuser
--

SELECT pg_catalog.setval('public.user_user_id_seq', 2, true);


--
-- Name: users user_pk; Type: CONSTRAINT; Schema: public; Owner: bookuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pk PRIMARY KEY (user_id);


--
-- Name: user_user_id_uindex; Type: INDEX; Schema: public; Owner: bookuser
--

CREATE UNIQUE INDEX user_user_id_uindex ON public.users USING btree (user_id);


--
-- PostgreSQL database dump complete
--

