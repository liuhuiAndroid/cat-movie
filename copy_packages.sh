#!/bin/bash

mkdir -p ./jars/

cp ./guns-gateway/target/guns-gateway-0.0.1.jar ./jars/
cp ./guns-user/target/guns-user-0.0.1.jar ./jars/
cp ./guns-film/target/guns-film-0.0.1.jar ./jars/
cp ./guns-cinema/target/guns-cinema-0.0.1.jar ./jars/
cp ./guns-order/target/guns-order-0.0.1.jar ./jars/

tar czf ./jars/project.tar.gz ./jars/
