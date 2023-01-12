import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent {

  userFound: User;
  idUser: number;
  constructor(private userService: UserService) {
    this.userFound = new User();
  }

  private _color = "light";

  users:any
  showModal = false;
  showModalAdd = false;

  toggleModal() {
    this.showModal = !this.showModal;
  }

  toggleModalAdd() {
    this.showModalAdd = !this.showModalAdd;
  }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((res)=>{
      this.users = res.data
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
        this.userService.deleteUser(id).subscribe((res)=>{
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

  update(tele: string) {
    this.userService.findUser(tele).subscribe((res)=>{
      this.userFound = res.data
      this.idUser = res.data.id
    })
  }

  updateUser(ngForm:NgForm) {
    this.userService.updateUser(this.idUser,this.userFound).subscribe((res)=>{


      if (res.status === 'success'){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: false,
          timer: 1500
        })
this.refresh()
      }
    })

  }

  updateStatusUser(id: number) {

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
        this.userService.bannUser(id).subscribe((res) => {
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
}

