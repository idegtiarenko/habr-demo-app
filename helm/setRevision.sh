#!/usr/bin/env sh
sed -i "s/\${revision}/$1/g" ./helm/Chart.yaml
