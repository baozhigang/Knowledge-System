<?php

function writeExcelFile($params) {
    $file = Arr::get($params, 'file', ROOT . "tmp/file1_" . time().rand(1,1000) . ".xlsx");
    $title = Arr::get($params, 'title', 'sheet1');
    $field = Arr::get($params, 'field', []);  
    $data = Arr::get($params, 'data', []);
    $sheet = Arr::get($params, 'sheet', 0);

    $spreadsheet = new \PhpOffice\PhpSpreadsheet\Spreadsheet();

    if ($data) {
        $worksheet = $spreadsheet->createSheet($sheet)->setTitle($title);

        $field_rows = $field ? 1 : 0;
        if (!empty($field)) {
            for ($col = 1; $col <= count($field); $col++) {
                $worksheet->setCellValueByColumnAndRow($col, $field_rows, $field[$col - 1]);
            }
        }

        $rows = count($data);
        for ($row = 1; $row <= $rows; $row++) {
            $item = array_values($data[$row - 1]);
            $cols = \count($item);
            for ($col = 1; $col <= $cols; $col++) {
                $worksheet->setCellValueByColumnAndRow($col, $row+$field_rows, $item[$col - 1]);
            }
        } 
    }        
    $writer = \PhpOffice\PhpSpreadsheet\IOFactory::createWriter($spreadsheet, 'Xlsx');
    $writer->save($file);
}