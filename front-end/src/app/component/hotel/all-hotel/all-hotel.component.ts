import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/model/hotel';
import { HotelService } from 'src/app/service/hotel.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-all-hotel',
  templateUrl: './all-hotel.component.html',
  styleUrls: ['./all-hotel.component.css']
})
export class AllHotelComponent implements OnInit {
  hotels: any;
  hotelFound!: Hotel;
  idHotel: number;

  constructor(private hotelService: HotelService, private router: Router) {
    this.hotelFound = new Hotel()
  }

  private _color = "light";

  showModal = false;
  showModalAdd = false;

  toggleModal() {
    this.showModal = !this.showModal;
  }

  toggleModalAdd() {
    this.showModalAdd = !this.showModalAdd;
  }

  ngOnInit(): void {
    this.hotelService.getAllHotel().subscribe((res) => {
      this.hotels = res;
    })
  }

  showDetails(id: number) {
    this.hotelService.getOneHotel(id).subscribe((res) => {
      this.router.navigate(['admin/one_hotel/' + id])
    })
  }

  updateStatus(id: number) {

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'bg-green-500 mx-3 text-white font-bold py-2 px-4 rounded',
        cancelButton: 'bg-red-500 text-white font-bold py-2 px-4 rounded'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: "update status hotel ",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, update',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.hotelService.updateStatusHotel(id).subscribe((res) => {
          if (res.status == 'success') {
            swalWithBootstrapButtons.fire(
              'Update',
              'status hotel updates',
              'success'
            )
            this.refresh()
          }
        })

      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        )
      }
    })

  }

  delete(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.hotelService.deleteHotel(id).subscribe((res: any) => {
          if (res.status == 'success') {
            Swal.fire(
              'Deleted!',
              res.message,
              'success'
            )
            this.refresh()
          }
        })

      }
    })
  }

  refresh(): void {
    window.location.reload();
  }

  update(id: number) {
    this.hotelService.getOneHotel(id).subscribe((res) => {
      this.hotelFound = res.data;
      this.idHotel = id;
    })
  }

  updateHotel(form: NgForm) {
    this.hotelService.updateHotel(this.hotelFound, this.idHotel).subscribe((res) => {
      if (res.status === 'success') {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: false,
          timer: 1500
        })
      }
      this.refresh()
    })
  }

}
