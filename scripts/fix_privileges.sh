##!/usr/bin/env bash
#chmod +x /home/ubuntu/server/* jar
#chmod +x /home/ubuntu/server/* war
#chmod +x /home/ubuntu/server/start_server.sh
#chmod +x /home/ubuntu/server/stop_server.sh


#sudo systemctl daemon-reload

#!/bin/bash

service_name="rebootServer.service"
service_path="/etc/systemd/system/$service_name"
original_service_path="/server/scripts/$service_name"

# Kiểm tra xem dịch vụ đã tồn tại hay chưa
if systemctl list-units --full --all | grep -Fq "$service_name"; then
    echo "Dịch vụ $service_name đã tồn tại. Không cần thêm mới."
else
    # Copy tệp .service vào thư mục systemd và làm mới systemd
    sudo cp "$original_service_path" "$service_path"
    sudo systemctl daemon-reload

    echo "Đã thêm mới dịch vụ $service_name và làm mới systemd."
fi
