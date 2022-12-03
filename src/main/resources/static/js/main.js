import * as THREE from 'three';
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls"; // FOR CAMERA CONTROL
import Stats from "three/examples/jsm/libs/stats.module"; // FOR DATA VISUALIZATION AND TESTING
import { GUI } from "dat.gui"; // LIBRARY FOR UI COMPONENTS
import { GLTFLoader } from "three/examples/jsm/loaders/GLTFLoader";

const scene = new THREE.Scene();

$(document).ready(function() {
    $(".favorite").on('click', function() {
        let customerId = $(this).attr("data-customer-id");
        let coffeeId = $(this).attr("data-coffee-id");
        $.post("/coffee/customer/" + customerId + "/favorite" + coffeeId);
    });
});