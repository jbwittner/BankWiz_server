--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2 (Debian 17.2-1.pgdg120+1)
-- Dumped by pg_dump version 17.2 (Debian 17.2-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bank_accounts; Type: TABLE; Schema: public; Owner: bankwiz_user
--

CREATE TABLE public.bank_accounts (
    initial_decimal_balance integer NOT NULL,
    bank_account_id uuid NOT NULL,
    currency_id uuid NOT NULL,
    user_id uuid NOT NULL,
    bank_account_name character varying(255) NOT NULL
);


ALTER TABLE public.bank_accounts OWNER TO bankwiz_user;

--
-- Name: currencies; Type: TABLE; Schema: public; Owner: bankwiz_user
--

CREATE TABLE public.currencies (
    currency_decimal_digits integer NOT NULL,
    currency_id uuid NOT NULL,
    currency_code character varying(255) NOT NULL,
    currency_name character varying(255) NOT NULL,
    currency_symbol character varying(255) NOT NULL
);


ALTER TABLE public.currencies OWNER TO bankwiz_user;

--
-- Name: user_accounts; Type: TABLE; Schema: public; Owner: bankwiz_user
--

CREATE TABLE public.user_accounts (
    user_id uuid NOT NULL,
    auth_id character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    full_name character varying(255) NOT NULL,
    nick_name character varying(255) NOT NULL
);


ALTER TABLE public.user_accounts OWNER TO bankwiz_user;

--
-- Name: bank_accounts bank_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: bankwiz_user
--

ALTER TABLE ONLY public.bank_accounts
    ADD CONSTRAINT bank_accounts_pkey PRIMARY KEY (bank_account_id);


--
-- Name: currencies currencies_pkey; Type: CONSTRAINT; Schema: public; Owner: bankwiz_user
--

ALTER TABLE ONLY public.currencies
    ADD CONSTRAINT currencies_pkey PRIMARY KEY (currency_id);


--
-- Name: user_accounts user_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: bankwiz_user
--

ALTER TABLE ONLY public.user_accounts
    ADD CONSTRAINT user_accounts_pkey PRIMARY KEY (user_id);


--
-- Name: bank_accounts fk43jdgloni1sdb2u78flrj6l6i; Type: FK CONSTRAINT; Schema: public; Owner: bankwiz_user
--

ALTER TABLE ONLY public.bank_accounts
    ADD CONSTRAINT fk43jdgloni1sdb2u78flrj6l6i FOREIGN KEY (currency_id) REFERENCES public.currencies(currency_id);


--
-- Name: bank_accounts fkp9nhweasjhghlwmk2631xrnbg; Type: FK CONSTRAINT; Schema: public; Owner: bankwiz_user
--

ALTER TABLE ONLY public.bank_accounts
    ADD CONSTRAINT fkp9nhweasjhghlwmk2631xrnbg FOREIGN KEY (user_id) REFERENCES public.user_accounts(user_id);


--
-- PostgreSQL database dump complete
--

