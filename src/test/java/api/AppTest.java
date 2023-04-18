package api;

import api.endpoints.Routes;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;


